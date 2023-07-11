package jsh.multikey.controller;

import jsh.multikey.application.MultiKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MultiKeyController {

    private final MultiKeyService multiKeyService;
}
