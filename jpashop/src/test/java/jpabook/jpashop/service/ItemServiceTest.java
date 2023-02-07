package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {
    @Autowired ItemRepository itemRepository;
    @Autowired ItemService itemService;
    @Autowired EntityManager em;

    @Test
    public void 아이템_저장_후_조회() throws Exception{
        //given
        Book book = new Book();
        book.setId(1L);
        book.setName("노인과 바다");
        book.setIsbn("1234-5532-iasd-1231");

        //when
        itemService.saveItem(book);
        Book findBook = (Book)itemService.findOne(1L);

        //then
        assertThat(book.getId()).isEqualTo(findBook.getId());
        assertThat(book.getName()).isEqualTo(findBook.getName());
        assertThat(book.getIsbn()).isEqualTo(findBook.getIsbn());
    }
}