package dom;

import java.util.ArrayList;
/**
 * Class name-DocumentObjectModel
 *
 *@version 1.0
 *author Jaya Bapna
 */
 
import java.util.List;

class SpanElement implements Element{
	String id;
	String cssClass;
	/**
	 * 
	 * @param id
	 * @param cssClass
	 */
	public SpanElement(String id, String cssClass) {
    	this.id = id;
    	this.cssClass = cssClass;
	}
	@Override
	public String getId(){
		return this.id;
	}
	@Override
	public String getCssClassName(){
		return this.cssClass;
	}
	public Element getObject(){
		return new SpanElement(this.id,this.cssClass);
	}

}
class DivElement implements Element{
	String id;
	String cssClass;
	List<Element> listOfInnerElements = new ArrayList<Element>();
	/**
	 * 
	 * @param id
	 * @param cssClass
	 */
	public DivElement(String id, String cssClass) {
    	this.id = id;
    	this.cssClass = cssClass;
	}
	@Override
	public String getId(){
		return this.id;
	}
	@Override
	public String getCssClassName(){
		return this.cssClass;
	}
	@Override
	public Element getObject(){
		return new DivElement(this.id,this.cssClass);
	}
}
class ButtonElement implements Element{
	String id;
	String cssClass;
	/**
	 * 
	 * @param id
	 * @param cssClass
	 */
	public ButtonElement(String id, String cssClass) {
    	this.id = id;
    	this.cssClass = cssClass;
	}
	@Override
	public String getId(){
		return this.id;
	}
	@Override
	public String getCssClassName(){
		return this.cssClass;
	}
	public Element getObject(){
		return new ButtonElement(this.id,this.cssClass);
	}
	
}

class ImgElement implements Element{
	String id;
	String cssClass;
	String src;
	/**
	 * 
	 * @param id
	 * @param cssClass
	 * @param src
	 */
	public ImgElement(String id, String cssClass, String src) {
    	this.id = id;
    	this.cssClass = cssClass;
    	this.src = src;
	}
	@Override
	public String getId(){
		return this.id;
	}
	@Override
	public String getCssClassName(){
		return this.cssClass;
	}
	public Element getObject(){
		return new ImgElement(this.id,this.cssClass, this.src = src);
	}
}


public class DocumentObjectModel {
	/**
	 * 
	 * @param args
	 */
	public static void main(String []args){
		List<Element> domList = new ArrayList<Element>();					//List to store Elements in hierarchy
		DOMHierarchy DOM = new DOMHierarchy();
		
		Element div1   = new DivElement("div1", "border");					
		Element div2   = new DivElement("div2", "border");
		Element span1  = new SpanElement("span1", "color");
		Element img    = new ImgElement("img1", "height", "D:\\img1.jpg");
		Element div3   = new SpanElement("div3", "color");
		Element button = new SpanElement("btn1", "padding");
		//Adding Elements to list
		domList.add(div1);
		domList.add(div2);
		domList.add(span1);
		domList.add(img);
		domList.add(div3);
		domList.add(button);
		
		Element foundElement = DOM.findElementById("div1", domList);
		
		List<Element> objectsOfClass = DOM.findElementsByClass("color", domList);
		
		System.out.println(foundElement.getId());
		System.out.println(foundElement);
		
		for(Element i : objectsOfClass){
	    	System.out.println(i.getId());
	    	System.out.println(i.getCssClassName());
		}
		
	}
	
}
