package com.bfly.management.customermanagement.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.bfly.management.config.cache.RedisUtil;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.customermanagement.slave.EmailAuthCheckReqModel;
import com.bfly.management.model.customermanagement.slave.EmailAuthReqModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailService extends BaseService {

    @Value("${customvalues.mail.logoUrl}")
    private String logoUrl;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RedisUtil redisUtil;
    
    public ApiResult<?> completeJoin(String email, String username) throws Exception {
        
        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        // result = this.slaveMapper.testQuery();

        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("imageurl", getByteArrayFromImageURL(logoUrl));
        username = "안녕하세요. "+username+"님 가입을 환영합니다 :)";
        hm.put("username",username);

        send("가입을 환영합니다", email, "welcome", hm);
        
        responseCode = CommonCode.COMMON_SUCCESS;

        return new ApiResult<String>(responseCode, result);
    }

    public ApiResult<?> emailAuthenticate(EmailAuthReqModel param) {

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        Random random = new Random();
        String authKey = String.valueOf(random.nextInt(888888) + 111111); // 범위 : 111111 ~ 999999

        try {
            sendAuthEmail(param.getEmail(), authKey);
            responseCode = CommonCode.COMMON_SUCCESS;
        } catch (Exception e) {
            log.info(e.getMessage());
            responseCode = CommonCode.COMMON_FAIL;
        }

        return new ApiResult<String>(responseCode, result);
    }

    public ApiResult<?> checkAuthenticate(EmailAuthCheckReqModel param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        Object redisResult = redisUtil.get(param.getToken() +""+ param.getEmail());

        if ( redisResult == null){
            responseCode = CommonCode.COMMON_EMAIL_CHECK_FAIL;
        }else{
            redisUtil.delete(param.getToken() +""+ param.getEmail());
            responseCode = CommonCode.COMMON_EMAIL_CHECK_SUCCESS;
        }
        return new ApiResult<String>(responseCode, result);
    }

    public void sendAuthEmail(String email, String authKey) throws Exception{
        String subject = "Bflysoft 인증 메일 입니다.";
        String text = "";

        String imageString = getByteArrayFromImageURL(logoUrl);
        text += "<div style=\"max-width: 600px; margin: 0 auto;\">";
        text += "<img width=\"120\" height=\"36\" style=\"margin-top: 0; margin-right: 0; margin-bottom: 32px; margin-left: 0px; padding-right: 30px; padding-left: 30px;\" src=\""+imageString+"\" alt=\"\">";
        text += "<h1 style=\"font-size: 30px; padding-right: 30px; padding-left: 30px;\">이메일 주소 확인</h1>";
        text += "<p style=\"font-size: 17px; padding-right: 30px; padding-left: 30px;\">&nbsp;고객님의&nbsp;확인&nbsp;코드는&nbsp;아래에&nbsp;있습니다.&nbsp;열려&nbsp;있는&nbsp;브라우저&nbsp;창에&nbsp;입력하시면&nbsp;고객님의&nbsp;로그인을&nbsp;도와드리겠습니다.&nbsp;</p>";
        text += "<div style=\"padding-right: 30px; padding-left: 30px; margin: 32px 0 40px;\">";
        text += "<table style=\"border-collapse: collapse; border: 0; background-color: #F4F4F4; height: 70px; table-layout: fixed; word-wrap: break-word; border-radius: 6px;\">";
        text += "<tbody>";
        text += "<tr>";
        text += "<td style=\"text-align: center; vertical-align: middle; font-size: 30px;\">"+authKey+"</td>";
        text += "</tr>";
        text += "</tbody>";
        text += "</table>";
        text += "</div>";
        text += "<p style=\"font-size: 17px; padding-right: 30px; padding-left: 30px;\"></p>";
        text += "<p style=\"font-size: 17px; padding-right: 30px; padding-left: 30px;\">이&nbsp;이메일을&nbsp;요청하지&nbsp;않았더라도&nbsp;걱정하지&nbsp;마세요.&nbsp;이메일을&nbsp;무시하면&nbsp;됩니다.</p>";
        text += "</div>";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(text, true);
        helper.setFrom("support@bflysoft.com");
        javaMailSender.send(mimeMessage);
        
        redisUtil.setData(authKey + "" + email, (Object)email, 60*5);
    }

    public String getByteArrayFromImageURL(String url) {

		try {
			URL imageUrl = new URL(url);
			URLConnection ucon = imageUrl.openConnection();
			InputStream is = ucon.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int read = 0;
			while ((read = is.read(buffer, 0, buffer.length)) != -1) {
				baos.write(buffer, 0, read);
			}
			baos.flush();
			byte[] fileArray = baos.toByteArray();
			String imageString = new String( Base64.encodeBase64( fileArray ) );

			String changeString = "data:image/jpg;base64, "+ imageString;

            return changeString;
		} catch (Exception e) {
		}
		return null;
	}

    public void send(String title, String to, String templateName, HashMap<String, String> values) throws MessagingException, IOException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        //메일 제목 설정
        helper.setSubject(title);

        //수신자 설정
        helper.setTo(to);

        //발신자 설정
        helper.setFrom("support@bflysoft.com");

        //템플릿에 전달할 데이터 설정
        Context context = new Context();
        values.forEach((key, value)->{
            context.setVariable(key, value);
        });

        //메일 내용 설정 : 템플릿 프로세스
        String html = templateEngine.process(templateName, context);
        helper.setText(html, true);

        //메일 보내기
        javaMailSender.send(message);
    }
}
