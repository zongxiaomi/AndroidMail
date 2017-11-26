package com.xiang.androidmail;

import android.util.Log;

import com.xiang.mail.Mail;
import com.xiang.mail.MailSender;

import java.io.File;


public class SendMailTool {


    //163
    private static final String HOST = "smtp.163.com";
    private static final String PORT = "25"; //
    private static final String FROM_ADD = "18353366239@163.com";
    private static final String FROM_PSW = "XXXX";

    public static void setHtml(String[] add,String[] cc,String[] bcc) {
        final Mail mail = createMail(add, null, null);
        mail.setContent("<h1>这是标题</h1>");
        final MailSender sender = new MailSender();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sender.sendHtmlMail(mail);
            }
        }).start();


    }

    public static void sendMailWithFile(final File file, String[] toAdd, String[] cc, String[] bcc) {
        final Mail mail = createMail(toAdd, cc, bcc);
        String content = mail.getContent();
        String s = content + "附件是第" + "次测试数据";
        mail.setContent(s);
        final MailSender sms = new MailSender();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sms.sendFileMail(mail, file);
                Log.e("附件发送成功", "------");
            }
        }).start();
    }


    public static void sendMail(String[] toAdd, String[] cc, String[] bcc) {
        final Mail mail = createMail(toAdd, cc, bcc);
        final MailSender sms = new MailSender();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sms.sendTextMail(mail);
            }
        }).start();
    }


    private static Mail createMail(String[] toAdds, String[] ccAdds, String bccAdds[]) {
        final Mail mail = new Mail();
        mail.setMailServerHost(HOST);
        mail.setMailServerPort(PORT);
        mail.setValidate(true);
        String[] split = FROM_ADD.split("@");

        mail.setUserName(split[0]); // 你的邮箱地址
        mail.setPassword(FROM_PSW);// 您的邮箱密码
        mail.setFromAddress(FROM_ADD); // 发送的邮箱
        mail.setToAddress(toAdds); // 发到哪个邮件去
        mail.setCcAddress(ccAdds);// 抄送邮件
        mail.setBccAddress(bccAdds);// 秘密抄送邮件
        mail.setSubject("蓝鲸测试结果"); // 邮件主题
        mail.setContent("嗨 all,"); // 邮件文本
        return mail;
    }

}
