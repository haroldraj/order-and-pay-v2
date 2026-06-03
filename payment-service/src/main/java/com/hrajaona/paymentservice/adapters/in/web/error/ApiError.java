package com.hrajaona.paymentservice.adapters.in.web.error;


import com.hrajaona.paymentservice.adapters.in.web.enums.ApiCodeError;

public record ApiError(ApiCodeError code, String message) {
}
