package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// http://docs.spring.io/spring-boot/docs/1.4.1.RELEASE/reference/html/

@SpringBootApplication

// DI�R���e�i���Ǘ����� Bean �������o�^���邽�߂̃A�m�e�[�V����
// �w�肵���p�b�P�[�W���N�_�Ƃ��āA�z���̃p�b�P�[�W���ċA�I�ɃX�L����
// @Component �ŃA�m�e�[�g���ꂽ�N���X�� Bean �Ƃ��ăR���e�i�ɓo�^
@ComponentScan // ("com.example")
public class DemoApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }
}
