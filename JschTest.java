package com.xmuchen.jschtest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class JschTest {

    public static void main(String args[]) throws JSchException, UnsupportedEncodingException {
        JSch jsch = new JSch();
        String host = null;
        String user = null;
        String password = null;
        user = "root";
        host = "192.168.100.1";//"ec2-54-242-46-232.compute-1.amazonaws.com";
        password = "netgear";
        //jsch.addIdentity("/home/lbchen/aws/keypair/lbcone.pem");
        Session session = jsch.getSession(user, host, 22);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        Channel channel = session.openChannel("exec");
        String input = null;
        input = "dpctl show tcp:127.0.0.1";
        InputStream insts = new ByteArrayInputStream(input.getBytes("UTF-8"));
        ((ChannelExec)channel).setCommand(input);
//        channel.setInputStream(insts);
        channel.setOutputStream(System.out);       
        channel.connect(3000);
    }
}
