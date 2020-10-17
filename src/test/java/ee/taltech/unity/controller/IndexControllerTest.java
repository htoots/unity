package ee.taltech.unity.controller;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    @Test
    void index_returns_correct_string() {
        var indexController = new IndexController().index();
        var expectedResponse = "API is up";

        assertEquals(indexController, expectedResponse);

    }
}