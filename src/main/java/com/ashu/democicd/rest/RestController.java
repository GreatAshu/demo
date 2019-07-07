package com.ashu.democicd.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	public Map<String, String> stateMap = new HashMap();

	@GetMapping("/state")
	public ResponseEntity get() {
		stateMap.put("BR", "Bihar");
		stateMap.put("KA", "Karnataka");
		stateMap.put("UP", "UtterPradesh");
		stateMap.put("DL", "Delhi");

		return new ResponseEntity(stateMap, HttpStatus.OK);
	}

	@PostMapping("/state")
	public ResponseEntity save(@RequestBody State s) {
		stateMap.put(s.getStateCode(), s.getStateName());
		return new ResponseEntity(stateMap, HttpStatus.CREATED);
	}

	@PutMapping("/state/{param}")
	public ResponseEntity update(@RequestBody State s, @PathVariable("param") String param) {
		stateMap.put(param, s.getStateName());
		return new ResponseEntity(stateMap, HttpStatus.OK);
	}

	@DeleteMapping("/state")
	public ResponseEntity delete() {
		stateMap.clear();
		return new ResponseEntity(stateMap, HttpStatus.NO_CONTENT);
	}

}
