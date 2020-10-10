package net.xdclass.demoproject;


import junit.framework.TestCase;
import net.xdclass.demoproject.domain.Video;
import net.xdclass.demoproject.service.VideoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={DemoProjectApplication.class})
@AutoConfigureMockMvc
public class Videotest {

    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    //模拟客户端
    @Test
    public void testVideoListApi()throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list")).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        System.out.println(status);

        //会乱码
        //String  result = mvcResult.getResponse().getContentAsString();

        //这个utf-8编码没问题
        String  result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));

        System.out.println(result);
    }

    @Before
    public void testOne() {
        System.out.println("test before");
    }

    @Test
    public void testVideoList(){

        List<Video> videoList = videoService.listVideo();

        TestCase.assertTrue(videoList.size()>0);

    }
//    @Test
//    public void testTwo1(){ //test都是并列的，单独执行，配before和after
//        System.out.println("test test1");
//
//        TestCase.assertEquals(1,3);
//    }
//
//    @Test
//    public void testTwo2(){
//        System.out.println("test test2");
//
//        TestCase.assertEquals(1,1);
//    }
//
//    @After
//    public void testThree(){
//        System.out.println("test after");
//    }

}
