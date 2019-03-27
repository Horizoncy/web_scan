package web_scan;
import java.io.*;
import java.net.*;
//import java.util.concurrent.*;
//import java.util.regex.*;
import java.util.*;




public class web_scan extends Thread{
	private int threadnum,startport,endport;
    private String ip;
    private int type;
    private int   common_port[]={21,22,23,25,53,123,161,162,389,443,512,513,873,1433,1080,1521,1900,2049,2601,2604,2082,2083,3128,3312,3306,4899,4440,8834,4848,3311,3312,3389,4440,5672,5900,6082,6379,7001,8080,8089,8161,8649,9000,9999,10050,11211,21017,28017,377,50000,50060,50070};
	public web_scan(String ip1 , int t) {
		this.ip = ip1;
		this.type = t;
	}
	public web_scan(int port1 , int port2, String ip3) {
		this.startport = port1;
		this.endport = port2;
		//System.out.println(port1+port2);
		this.ip = ip3;
	}
	public int scanportalive(int port){
        
		Socket socket=null;
		int flag=1;
		try{
			socket=new Socket();
			SocketAddress address=new InetSocketAddress(this.ip, port);
			socket.connect(address,100);
			socket.close();
		}catch (IOException e) {
			System.out.println(this.ip+"��"+port+"�˿ڹر�");
			flag=0;
		}
		if (flag==0) return -1;
		System.out.println(this.ip+"��"+port+"�˿ڿ���");
		switch(port){
        	case(21):System.out.println("Ĭ����ftp�˿�  ��Ҫ���Ƿ�֧��������Ҳ������������");break;
        	case(22):System.out.println("Ĭ����ssh�˿�");break;
        	case(23):System.out.println("Ĭ����telnet�˿�");break;
        	case(25):System.out.println("Ĭ����smtp����");break;
        	case(53):System.out.println("Ĭ����DNS");break;
        	case(123):System.out.println("Ĭ����NTP");break;
        	case(161):
        	case(162):System.out.println("snmp����8161 IBMһ���Ʒ�����ŵ�SNMP��");break;
        	case(389):System.out.println("ldap����");break;
        	case(443):System.out.println("openssl  ��hearthleed");break;
        	case(512):
        	case(513):System.out.println("rlogin���������exec");break;
        	case(873):System.out.println("rsync ��Ҫ���Ƿ�֧��������Ҳ������������");break;
        	case(1433):System.out.println("mssql���ݿ�");break;
        	case(1080):System.out.println("socks����");break;
        	case(1521):System.out.println("oracle");break;
        	case(1900):System.out.println("besĬ�Ϻ�̨");break;
        	case(2049):System.out.println("nfs����");break;
        	case(2601):
        	case(2604):System.out.println("zebra·�� Ĭ������zebra");break;
        	case(2082):
        	case(2083):System.out.println("cpanel��������ϵͳ");break;
        	case(3182):
        	case(3306):System.out.println("mysql���ݿ�");break;
        	case(4899):System.out.println("R-admin ���Ӷ�");break;
        	case(4440):System.out.println("rundeck rundeck  �ο�WooYun: ��������ĳ����ɹ�������������");break;
        	case(8834):System.out.println("nessus");break;
        	case(4848):System.out.println("glashfish");break;
        	case(3312):
        	case(3311):System.out.println("kangle��������ϵͳ");break;
        	case(3389):System.out.println("Զ�̵�¼");break;
        	case(5672):System.out.println("rabbitMQ");break;
        	case(5900):System.out.println("VNC");break;
        	case(6082):System.out.println("varnish  �ο�WooYun: Varnish HTTP accelerator CLI δ��Ȩ�����׵�����վ��ֱ�Ӵ۸Ļ�����Ϊ�����������");break;
        	case(6379):System.out.println("redis һ������֤����ֱ�ӷ���");break;
        	case(7001):System.out.println("weblogic");break;
        	case(8080):System.out.println("tomcat");break;
        	case(8089):System.out.println("jboss");break;
        	case(8161):System.out.println("activeMQ");break;
        	case(8649):System.out.println("ganglia��Ⱥϵͳ������");break;
        	case(9000):System.out.println("fastcgi����");break;
        	case(9090):System.out.println("IBM����");break;
        	case(9200):
        	case(9300):System.out.println("elasticsearch  �ο�WooYun: ����ĳ������ElasticSearch����ִ��©��");break;
        	case(9999):System.out.println("amg���ܰ�");break;
        	case(10050):System.out.println("zabbix");break;
        	case(11211):System.out.println("memcache  δ��Ȩ����");break;
        	case(27017):
        	case(28017):System.out.println("mongodb  δ��Ȩ����   mongodbĬ���޿����¼");break;
        	case(3777):System.out.println("�󻪼���豸");break;
        	case(50000):System.out.println("sap netweaverԶ������ִ��©��");break;
        	case(50060):
        	case(50070):System.out.println("hahoop��apache hasoop");break;
		}
		return 0;
	}
	
	public void typeA(){
		for(int i=0;i<=45;i++){
			scanportalive(this.common_port[i]);
		}
	}
	public void typeB(){
		for(int i=this.startport;i<=this.endport;i++){
			scanportalive(i);
		}
	}
}
