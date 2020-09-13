package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {360450L, 360449L, 360448L, 360447L,
			360446L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i ->{
			ReplyVO vo = new ReplyVO();
			
			vo.setBno( bnoArr [i % 5]);
			vo.setReply("댓글테스트"+i);
			vo.setReplyer("replyer"+i);
			
			mapper.insert(vo);
			
		});
	}
	
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}

}
