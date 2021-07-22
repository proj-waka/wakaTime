package com.wakaTime.service;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wakaTime.domain.BoardVO;
import com.wakaTime.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
  @Setter(onMethod_ = {@Autowired})
  private BoardService service;

  //  @Test
  public void testExist() {
    log.info(service);
    assertNotNull(service);
  }

  //  @Test
  public void testRegister() {
    BoardVO board = new BoardVO();
    board.setTitle("새로 작성하는 글 select key");
    board.setContent("새로 작성하는 내용 select key");
    board.setWriter("newbie");

    service.register(board);

    log.info("생성된 게시물의 번호:"+ board.getBno());
  }

  //  @Test
  public void testGetList() {
    service.getList().forEach(board -> log.info(board));
  }

  //  @Test
  public void testGet() {
    log.info(service.get(6L));
  }

  //  @Test
  public void testModify() {
    BoardVO board = service.get(1L);

    if(board == null) {
      return;
    }

    board.setTitle("수정된 제목");

    log.info("MODIFY RESULT:" + service.modify(board));
  }

  @Test
  public void testDelete() {
    log.info("REMOVE RESULT:"+service.remove(2L));
  }
}
