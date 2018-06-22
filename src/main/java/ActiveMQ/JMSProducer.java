package ActiveMQ;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

class JMSProducer{
  //默认连接用户名
  private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
  //默认连接密码
  private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
  //默认连接地址
  private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

  private static final int SENDNUM = 10;
  public static void main(String args[]){
        ConnectionFactory connectionFactory;
        Connection connection;

        Session session;
        Destination destination;

        MessageProducer messageProducer;

        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);

    try {
      connection = connectionFactory.createConnection();
      connection.start();

      session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
      destination = session.createQueue("hello world");

      messageProducer =session.createProducer(destination);

      TextMessage message = session.createTextMessage("hello this is actiove mq");
      messageProducer.send(message);

      session.commit();

    } catch (JMSException e) {
      e.printStackTrace();
    }

  }
}