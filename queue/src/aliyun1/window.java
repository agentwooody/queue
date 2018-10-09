package aliyun1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ClientException;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.common.utils.ServiceSettings;
import com.aliyun.mns.model.QueueMeta;
import com.aliyun.mns.model.Message;
import java.lang.String;


public class window extends JFrame
{  
	 public static void main(String[] args) {  
	 CreateQueue.CreateQueue();
		 		 
	 JFrame f=new JFrame("发布订阅");  
	 f.setSize(500,400);  
	 f.setLocation(300,200);  
	 f.setLayout(null);  
	 
	 JTextArea tSend1 = new JTextArea();
	 tSend1.setBounds(50, 100, 170, 100);
	 tSend1.setLineWrap(true);
     f.add(tSend1);
     
     JTextArea tReceive1 = new JTextArea();
     tReceive1.setBounds(250, 100, 170, 100);
     tReceive1.setLineWrap(true);
     f.add(tReceive1);
     
     JTextArea tSend2 = new JTextArea();
	 tSend2.setBounds(50, 220, 170, 100);
	 tSend2.setLineWrap(true);
     f.add(tSend2);
     
     JTextArea tReceive2 = new JTextArea();
     tReceive2.setBounds(250, 220, 170, 100);
     tReceive2.setLineWrap(true);
     f.add(tReceive2);

     JButton s1 = new JButton("发送1");
     s1.setBounds(50, 20, 70, 30);
     f.add(s1); 
     
     JButton s2 = new JButton("发送2");
     s2.setBounds(150, 20, 70, 30);
     f.add(s2); 
     
     //JButton s3 = new JButton("全部发送");
     //s3.setBounds(150, 20, 70, 30);
     //f.add(s3); 
     
     JButton r1 = new JButton("接收1");
     r1.setBounds(250, 20, 70, 30);
     f.add(r1); 
     
     JButton r2 = new JButton("接收2");
     r2.setBounds(350, 20, 70, 30);
     f.add(r2); 
     
     JButton r3 = new JButton("全部接收");
     r3.setBounds(150, 60, 70, 30);
     f.add(r3); 
     
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setVisible(true);  
     
     s1.addActionListener(new ActionListener()
     {
         public void actionPerformed(ActionEvent e) {

             //获取send1中的文本
             String s_str = tSend1.getText().trim();
             tSend1.setText("");
             Producer.Producer(s_str);
         }
     });
     
     s2.addActionListener(new ActionListener()
     {
         public void actionPerformed(ActionEvent e) {

             //获取send2中的文本
             String s_str = tSend2.getText().trim();
             tSend2.setText("");
             Producer.Producer(s_str);
         }
     });
     
    r1.addActionListener(new ActionListener()
     {
         public void actionPerformed(ActionEvent e) {

             //获取队列中的消息
             String s_str = Comsumer.comsumer();
             tReceive1.setText(s_str);
         }
     });

    r2.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e) {

            //获取队列中的消息
            String s_str = Comsumer.comsumer();
            tReceive2.setText(s_str);
        }
    });
    
    r3.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e) {

        //获取队列中的消息
        String s_str = Comsumer.comsumer();
        tReceive1.setText(s_str);
        tReceive2.setText(s_str);
     }
	 });

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);

}  
}

