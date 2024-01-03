package hello.itemservice.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository= new ItemRepository();

    @AfterEach
    void aftherEach(){
        itemRepository.clearSotre();
    }
    @Test
    void save(){
        //given
        Item item = new Item("itemA", 2000, 10);
        // when
        Item saveditem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(saveditem).isEqualTo(findItem);
    }

    @Test
    void findAll(){
        // given
        Item item1 = new Item("itemA", 2000, 10);
        Item item2 = new Item("itemB", 3000, 10);
        itemRepository.save(item1);
        itemRepository.save(item2);
        // when
        List<Item> items = itemRepository.findAll();
        //then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(item1,item2);
    }

    @Test
    void updateItem(){
        // given
        Item item = new Item("itemA", 2000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();
        // when
        Item updateItem = new Item("itemB", 3000, 20);
        itemRepository.update(itemId,updateItem);
        // then
        Item findeItem = itemRepository.findById(itemId);
        assertThat(findeItem.getItemName()).isEqualTo(updateItem.getItemName());
        assertThat(findeItem.getPrice()).isEqualTo(updateItem.getPrice());
        assertThat(findeItem.getQuantity()).isEqualTo(updateItem.getQuantity());

    }
}