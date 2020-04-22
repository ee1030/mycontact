package com.fastcampus.javaallinone.project3.mycontact.repository;
import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BlockRepositoryTest {
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud() {
        Block block = new Block();

        block.setName("John Wick");
        block.setReason("excommunicado");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now());

        blockRepository.save(block);

        List<Block> blocks = blockRepository.findAll();

        assertThat(blocks.size()).isEqualTo(3);
        assertThat(blocks.get(0).getName()).isEqualTo("Winston");
        assertThat(blocks.get(1).getName()).isEqualTo("Eminem");
        assertThat(blocks.get(2).getName()).isEqualTo("John Wick");
    }

}