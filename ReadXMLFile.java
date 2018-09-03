import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.util.Scanner;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
 public class ReadXMLFile{

  
   public static void main(String argv[]) {
    

	   try {
	 System.out.println (" 정거장id를 입력하세요");
Scanner s= new Scanner(System.in);
String busstopid = "";
busstopid = s.next();
 String url = "http://api.gwangju.go.kr/xml/arriveInfo?serviceKey="서비스키"&BUSSTOP_ID="+busstopid;
 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 Document doc = dBuilder.parse(url);
		  doc.getDocumentElement().normalize();
				   
    // System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
     NodeList nList = doc.getElementsByTagName("ARRIVE");
	 System.out.println("-----------------------");
  
	  for (int temp = 0; temp < nList.getLength(); temp++) {
						 
	     Node nNode = nList.item(temp);
	    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		String busstopname = "";

	       Element eElement = (Element) nNode;
		
		   System.out.println( getTagValue("LINE_NAME", eElement));
		   System.out.println("남은시간 : " + getTagValue("REMAIN_MIN", eElement));
		   System.out.println("현재위치 : " + getTagValue("BUSSTOP_NAME", eElement));
		   System.out.println("남은정거장 : " + getTagValue("REMAIN_STOP", eElement));
		   System.out.println(getTagValue("DIR_START",eElement) + " 출발    "+getTagValue("DIR_END",eElement)+"  도착" );


int remainmin = Integer.parseInt(getTagValue("REMAIN_MIN",eElement));

if(remainmin<=3)
{System.out.println("곧도착합니다");}



System.out.println(" ");
													   }//if
												     	    }//for
					   } catch (Exception e) {
		   e.printStackTrace();
										    } //catch
											  }//main
														   private static String getTagValue(String sTag, Element eElement) {
													
													      NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
																											   
																											           Node nValue = (Node) nlList.item(0);
																													    
																														 return nValue.getNodeValue();}
										   }//method																										
