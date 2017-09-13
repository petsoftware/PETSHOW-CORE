package br.com.petshow.tests.util;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import br.com.petmooby.util.CollectionUtil;

public class TestCollectionUtil {
	@Test
	public void testRemoveStringCollection() {
		List<String> list = new ArrayList<>();
		list.add("raimundo");
		list.add("joão");
		list.add("maria");
		list.add("Jose");
		list.add("Bruno");
		
		List<String> listClone = new ArrayList<>();
		listClone.add("joão");
		listClone.add("maria");
		listClone.add("Jose");
		listClone.add("Bruno");
	
		list = CollectionUtil.removeItem(list, "raimundo");
		
		assertEquals(listClone, list);
		
	}

}
