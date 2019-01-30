package com.springboot.lamaspringboot;

import org.springframework.web.bind.annotation.*;

@RestController
public class GetController {
    SingleLinkedList list = new SingleLinkedList();

    @RequestMapping(path = "/get/linkedlist/add/{val}", method = RequestMethod.GET)
    @ResponseBody
    public String getAddToList(@PathVariable String val) {
        list.addLast(val);
        return list.show().toString();
    }

    @RequestMapping(path = "/get/linkedlist/removematch/{val}", method = RequestMethod.DELETE)
    @ResponseBody
    public String getRemoveByMatch(@PathVariable String val) {
        list.removeByMatch(val);
        return list.show().toString();
    }

    @RequestMapping(path = "/post/linkedlist/add", method = RequestMethod.POST)
    @ResponseBody
    public String postAddToList(@RequestBody String[] name) {
        for(String str: name) {
            list.addLast(str);
        }
        return list.show().toString();
    }

    @RequestMapping(path = "/put/linkedlist/update/{existVal}/{newValue}", method = RequestMethod.PUT)
    @ResponseBody
    public String putUpdateList(@PathVariable String existVal, @PathVariable String newValue) {
        list.updateElement(existVal, newValue);
        return list.show().toString();
    }
}