package ActiveMQ;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by huangxiaolong on 2016/9/18.
 */
public class JMSConsumer {
  private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//默认连接用户名
  private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认连接密码
  private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接地址

  public static void main(String[] args) {
    ConnectionFactory connectionFactory;//连接工厂
    Connection connection = null;//连接

    Session session;//会话 接受或者发送消息的线程
    Destination destination;//消息的目的地

    MessageConsumer messageConsumer;//消息的消费者

    //实例化连接工厂
    connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);

    try {
      connection = connectionFactory.createConnection();
      connection.start();
      session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      destination = session.createQueue("hello world");
      messageConsumer = session.createConsumer(destination);

      while (true) {
        TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
        if (textMessage != null) {
          System.out.println("收到的消息:" + textMessage.getText());
        } else {
          break;
        }
      }


    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}
