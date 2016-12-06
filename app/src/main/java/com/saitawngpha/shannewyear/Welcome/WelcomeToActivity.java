package com.saitawngpha.shannewyear.Welcome;

/**
 * Created by Sai Pha on 11/26/2016.
 */

import android.os.Bundle;

import com.saitawngpha.shannewyear.R;
import com.stephentuso.welcome.*;
import com.stephentuso.welcome.WelcomeHelper;

/**
 * Created by stephentuso on 11/15/15.
 */
public class WelcomeToActivity extends WelcomeActivity {

    private static final int REQUEST_WELCOME_SCREEN_RESULT = 13;

    private WelcomeHelper WelcomeToScreen;

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultTitleTypefacePath("fonts/PangLong.ttf")
                .defaultHeaderTypefacePath("fonts/PangLong.ttf")
                .defaultDescriptionTypefacePath("fonts/PangLong.ttf")

                .page(new BasicPage(R.drawable.sh1,
                        "ႁူမ်ၸူမ်း...",
                        "တႆးတိုတ်ႉတၢႆးတႆးတူဝ်းတွၼ်း")
                        .background(R.color.orange_background)
                )

                .page(new BasicPage(R.drawable.sh2,
                        "ႁပ်ႉတွၼ်ႈ...",
                        "တႆးတဵၵ်းတဵင်တႆးတူၵ်းတႅမ်ႇ")
                        .background(R.color.green_background)
                )

                .page(new BasicPage(R.drawable.sh3,
                        "ပီမႂ်ႇတႆး ႒႑႑႑ ၼီႈ!",
                        "ႁႂ်ႈတူဝ်ၵေႃႈမႂ်ႇ ၸႂ်ၵေႃႈမႂ်ႇ…\nႁႂ်ႈယူႇလီမီးငိုၼ်း ႁႂ်ႈႁၢင်ႈလီၵိုၵ်းပိုၼ်း…")
                       // .lastParallaxFactor(2f)
                        .background(R.color.red_background)
                )

                .page(new BasicPage(R.drawable.sh4,
                        "Happy Shan New Year 2111",
                        "Welcome to Shan New Year 2111.\n Be Completely with your wish.")
                        .background(R.color.blue_background)
                )

                .swipeToDismiss(true)
                .exitAnimation(android.R.anim.fade_out)
                .build();
    }

    public static String welcomeKey() {
        return "WelcomeScreen";
    }


}