package jp.gr.java_conf.hungrywalker.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// http://docs.spring.io/spring-boot/docs/1.4.1.RELEASE/reference/html/

@SpringBootApplication

// DIコンテナが管理する Bean を自動登録するためのアノテーション
// 指定したパッケージを起点として、配下のパッケージを再帰的にスキャン
// @Component でアノテートされたクラスを Bean としてコンテナに登録
@ComponentScan // ("com.example")
public class DemoApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }
}
