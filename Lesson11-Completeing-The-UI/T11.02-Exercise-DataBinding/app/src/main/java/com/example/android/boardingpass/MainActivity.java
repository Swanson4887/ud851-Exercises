package com.example.android.boardingpass;

/*
* Copyright (C) 2016 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import android.databinding.DataBindingUtil;
import java.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.boardingpass.databinding.ActivityMainBinding;
import com.example.android.boardingpass.utilities.FakeDataUtils;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        BoardingPassInfo boardinginfo = FakeDataUtils.generateFakeBoardingPassInfo();

        // TODO (9) Call displayBoardingPassInfo and pass the fake BoardingInfo instance
        displayBoardingPassInfo(boardinginfo);

    }

    private void displayBoardingPassInfo(BoardingPassInfo info) {
        mBinding.textViewPassengerName.setText(info.passengerName);
        mBinding.textViewArrivalTime.setText(info.arrivalTime.toString());
        mBinding.textViewBoardingInCountdown.setText(info.boardingTime.toString());
        mBinding.textViewTerminal.setText(info.departureTerminal.toString());
        mBinding.textViewDepartureTime.setText(info.departureTime.toString());
        mBinding.textViewGate.setText(info.departureGate);
        mBinding.textViewSeat.setText(info.seatNumber);
        mBinding.textViewFlightCode.setText(info.flightCode);
        mBinding.textViewOriginAirport.setText(info.originCode);
        mBinding.textViewDestinationAirport.setText(info.destCode);


        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String BoardingTime = formatter.format(info.boardingTime);
        String ArrivalTime = formatter.format(info.arrivalTime);
        String DepartureTime = formatter.format(info.departureTime);

        mBinding.textViewBoardingTime.setText(BoardingTime);
        mBinding.textViewArrivalTime.setText(ArrivalTime);
        mBinding.textViewDepartureTime.setText(DepartureTime);

        // TODO (8) Use TimeUnit methods to format the total minutes until boarding
        long totalminuntilboard = info.getMinutesUntilBoarding();
        long hoursUntilBoarding = TimeUnit.MINUTES.toHours(totalminuntilboard);
        long minuteslesshouruntilboarding = totalminuntilboard - TimeUnit.HOURS.toMinutes(hoursUntilBoarding);

        String Hoursandmintillboard = getString(R.string.countDownFormat,
                hoursUntilBoarding,
                minuteslesshouruntilboarding);

        mBinding.textViewBoardingInCountdown.setText(Hoursandmintillboard);
    }
}

