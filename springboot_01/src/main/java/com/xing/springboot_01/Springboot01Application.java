package com.xing.springboot_01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 汪东兴 on 2016-11-30.
 */
@RestController()
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //关闭特定的自定义配置
/*@EnableConfigurationProperties({BookBean.class})*/
public class Springboot01Application {

	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.name}")
	private String bookName;

    /*@Autowired
    private BookBean bookBean;*/

	@RequestMapping("/")
	public String index() {
		return  "book name is :" + bookName + ",book author is :" + bookAuthor;
//        return  "book name is :" + bookBean.getName() + ",book author is :" + bookBean.getAuthor();
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Springboot01Application.class);
		//关闭banner
//        application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
