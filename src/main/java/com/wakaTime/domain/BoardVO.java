package com.wakaTime.domain;

import java.util.Date;
import lombok.Data;

/**
 * 게시물 VO
 * 
 * @author cgKim, hsLee
 * @since 2021. 07. 22.
 *
 */

@Data
public class BoardVO {
  private Long bno;
  private String title;
  private String content;
  private String writer;
  private Date regdate;
  private Date updateDate;
}
