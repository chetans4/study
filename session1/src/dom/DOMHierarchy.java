package dom;

import java.util.ArrayList;
import java.util.List;
/**
 * Class name-DOMHierarchy
 *
 *@version 1.0
 *author Jaya Bapna
 */
 
/*
 * A class of Document Object Model Hierarchy
 */
public class DOMHierarchy {
	/**
	 * Below functions returns the object if id is equal to id if any object in hierarchy.
	 * @param id
	 * @param domList
	 * @return object of Element if id is found otherwise returns null
	 */
	public Element findElementById(String id, List<Element> domList){
		for(Element i : domList){
			if(id == i.getId()){
				return i;														//returns object of Element
			}
		}
		return null;
	}
	/**
	 * Below function returns list of object having class equals to cssClass in hierarchy.
	 * @param cssClass
	 * @param domList
	 * @return list of objects having same class
	 */
	
	public List<Element> findElementsByClass(String cssClass, List<Element> domList){
		List<Element> elementsOfClass = new ArrayList<Element>();				//List to store Elements having same class.
		for(Element i : domList){
			if(cssClass == i.getCssClassName()){
				elementsOfClass.add(i);
			}
		}
		return elementsOfClass;													//returns final list of Element
	}
}
