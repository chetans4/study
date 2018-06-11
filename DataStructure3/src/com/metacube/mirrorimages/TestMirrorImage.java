package com.metacube.mirrorimages;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMirrorImage {

	@Test
	public void testMirrorImageSuccess() {
		Tree treeA = new Tree();
		Tree treeB = new Tree();
		MirrorImage mirrorImageInstance = new MirrorImage();
		treeA.insert(10);
		treeA.insert(6);
		treeA.insert(30);
		treeA.insert(4);
		treeA.insert(8);
		treeA.insert(28);
		treeA.insert(31);
		treeB.insertReverse(10);
		treeB.insertReverse(30);
		treeB.insertReverse(6);
		treeB.insertReverse(31);
		treeB.insertReverse(28);
		treeB.insertReverse(8);
		treeB.insertReverse(4);
		assertTrue(mirrorImageInstance.mirrorImages(treeA.root, treeB.root));
	}
	
	@Test
	public void testMirrorImageFailur() {
		Tree treeA = new Tree();
		Tree treeB = new Tree();
		MirrorImage mirrorImageInstance = new MirrorImage();
		treeA.insert(10);
		treeA.insert(6);
		treeA.insert(30);
		treeA.insert(4);
		treeA.insert(8);
		treeA.insert(28);
		treeA.insert(31);
		treeB.insertReverse(10);
		treeB.insertReverse(30);
		treeB.insertReverse(6);
		treeB.insertReverse(31);
		treeB.insertReverse(28);
		treeB.insertReverse(8);
		assertTrue(mirrorImageInstance.mirrorImages(treeA.root, treeB.root));
	}
}
