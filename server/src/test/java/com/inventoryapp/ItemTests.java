package com.inventoryapp;

import com.inventoryapp.controllers.ItemController;
import com.inventoryapp.entities.Item;
import com.inventoryapp.repositories.ItemRepository;
import com.inventoryapp.services.ItemService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ItemTests {

    @Autowired
    @Mock
    ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @InjectMocks
    ItemService itemService;

    @Autowired
    @InjectMocks
    ItemController itemController;
    Item item = new Item();
//    Item builderItem = item.builder().id(1).category("hello");
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
        when(itemController.getById(0)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> itemController.getById(0));
    }


    @Test
    public void saveItem_creates_new_item_if_given_id_does_not_exist() {
       when(itemService.saveItem(item)).thenReturn(item);


       Item createdItem = itemService.saveItem(item);
        System.out.println("created item: " + createdItem);
        assertEquals(createdItem, item);

    }

    @Test(expected = IllegalArgumentException.class)
    public void saveItem_throws_exception_if_fields_left_blank() {
        item.setName("");
        when(itemService.saveItem(item)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> itemService.saveItem(item));
    }


}
