package by.sTm.t2.controller;

import by.sTm.t2.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/t2/history")
    public String getHistory(Model model) {
        model.addAttribute("listHistory", historyService.getList());
        return "history";
    }
}
