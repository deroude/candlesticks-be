/*
 * (c)Viavi Solutions 2018
 * Last modified: Tuesday, 17th July 2018 8:54:17 pm
 * Author: Valentin Raduti (deroude@gmail.com>)
 */
package com.viavisolutions.candlesticks.controller;

import com.viavisolutions.candlesticks.domain.DataBatch;
import com.viavisolutions.candlesticks.service.DataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * Rest controller for the data endpoint
 */
@RestController
@RequestMapping("/data")
@Api(value = "data series", description = "API endpoint providing operations on the data series")
public class DataController {
    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    private final DataService dataService;

    @Autowired
    public DataController(final DataService dataService) {
        logger.info("entered");
        this.dataService = dataService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get most recent data batch", response = DataBatch.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "I don't know who you are - you need to authenticate"),
            @ApiResponse(code = 403, message = "I know who you are, but you are not allowed to see this"),
            @ApiResponse(code = 404, message = "Nothing here, Bob") })
    @CrossOrigin(origins = "*", allowedHeaders = { "Origin", "X-Requested-With", "Content-Type", "Accept" })
    public DataBatch getData() {
        return this.dataService.getSnapshot();
    }
}