package jp.co.bizrefine.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jp.co.bizrefine.entity.Event;
import jp.co.bizrefine.repository.EventRepository;


@RestController
@RequestMapping(value ="/api/event")
public class RestWebController {

	@Autowired
    EventRepository eRepository;

    /**
     * カレンダーのイベントを全取得する
     *
     * @return List<Event>
     */
    @GetMapping(value = "/all")
    public List<Event> getEvents() {
        List<Event> events = eRepository.findAll();
        return events;
    }

    /**
     * カレンダーのイベントを更新する
     *
     * @param event
     */
    @ResponseBody
    @PostMapping(value="/update",consumes=MediaType.APPLICATION_JSON_VALUE)
    public void post(@RequestBody Event event) throws JsonParseException, JsonMappingException, IOException  {
    	eRepository.saveAndFlush(event);
    }

    /**
     * カレンダーのイベントを削除する
     *
     * @param event
     */
    @ResponseBody
    @PostMapping(value="/delete",consumes=MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody Event event) throws JsonParseException, JsonMappingException, IOException  {
    	eRepository.delete(event);
    }
}