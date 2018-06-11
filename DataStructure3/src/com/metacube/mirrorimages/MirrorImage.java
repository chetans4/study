package com.metacube.mirrorimages;

/*
 * Class name- MirrorImage
 * This class checks whether two binary trees are mirror image of each other or not.
 */
public class MirrorImage {
	/**
	 * Below function checks if two trees are mirror images of each other or not.
	 * @param rootA
	 * @param rootB
	 * @return true if mirror image otherwise false
	 */
	public boolean mirrorImages(Node rootA, Node rootB) {
		if ( rootA == null && rootB == null ) {
			return true;
		}
		
		if ( rootA == null || rootB == null ) {
			return false;
		}
		return rootA.data == rootB.data  && mirrorImages(rootA.left, rootB.right) && mirrorImages(rootA.right, rootB.left);
	}
}
