package jp.co.bizrefine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.bizrefine.entity.Event;


@Controller
public class CalendarController {

    /**
     * 初期画面を展開する
     *
     * @return Calendarmain	 メイン画面
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index1(Model model) {
    	model.addAttribute("event", new Event());
        return "Calendarmain";
    }

    /**
     * メイン画面を展開する
     *
     * @return Calendarmain メイン画面
     */
    @RequestMapping(value = "/Calendarmain", method = RequestMethod.GET)
    String index2(Model model) {
        return "Calendarmain";
    }

    /**
     * 登録画面へ遷移時、イベント情報をフォームに設定する
     *
     * @param event
     * @return Calendaradd 登録画面
     */
    @RequestMapping(value="/Calendaradd", method=RequestMethod.POST)
    public String indexFormSubmit(@ModelAttribute Event event, Model model) {
        model.addAttribute("event", event);
        return "Calendaradd";
    }
}