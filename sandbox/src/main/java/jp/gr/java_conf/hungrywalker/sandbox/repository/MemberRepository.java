package jp.gr.java_conf.hungrywalker.sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.gr.java_conf.hungrywalker.sandbox.entity.MemberEntity;

// http://libro.tuyano.com/index2?id=4466003
// http://libro.tuyano.com/index3?id=12186003
public interface MemberRepository extends JpaRepository<MemberEntity, Long>
{
    public MemberEntity findByUsername(String username);
}
