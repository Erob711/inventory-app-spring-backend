package com.inventoryapp;

import com.inventoryapp.entities.Item;
import com.inventoryapp.repositories.ItemRepository;
import com.inventoryapp.services.ItemService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
public class ItemTests {

    @Mock
    ItemRepository itemRepository;
    @InjectMocks
    ItemService itemService;

    Item item = new Item();

    @Before
    public void setup() throws Exception {
        item.setId(15000);
        item.setName("Test");
        item.setCategory("Test");
        item.setDescription("Test");
        item.setPrice(1.00);
        item.setImage("Test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_given_zero_throws_exception() {
        when(itemService.findById(0)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> itemService.findById(0));
    }


    @Test
    public void saveItem_creates_new_item_if_given_id_does_not_exist() {
       when(itemService.saveItem(item)).thenReturn(item);
       assertEquals(itemService.saveItem(item), item);

    }


}
