
package drll.problems.hackerRank.journeyToTheMoon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

class JourneyToTheMoonTest {

    @Test
    void should_work_for_test_case1() {
        long pairs = JourneyToTheMoon.journeyToMoon(4, new int[][]{{0, 2}});

        assertThat(pairs).isEqualTo(5);
    }

    @Test
    void should_work_for_test_case2() {
        long pairs = JourneyToTheMoon.journeyToMoon(5, new int[][]{{0, 1}, {2, 3}, {0, 4}});

        assertThat(pairs).isEqualTo(6);
    }

    @Test
    void should_work_for_test_case3() {
        long pairs = JourneyToTheMoon.journeyToMoon(4, new int[][]{{1, 2}, {2, 3}});

        assertThat(pairs).isEqualTo(3);
    }

    @Test
    void should_work_for_test_case4() {
        long pairs = JourneyToTheMoon.journeyToMoon(10, new int[][]{{0, 2}, {1, 8}, {1, 4},
                {2, 8}, {2, 6}, {3, 5},
                {6, 9}});

        assertThat(pairs).isEqualTo(23);
    }

    @Test
    void should_work_for_test_case5() {

        long pairs = JourneyToTheMoon.journeyToMoon(100, buildTestCase5());

        assertThat(pairs).isEqualTo(3984);
    }

    @Test
    void should_work_for_test_case6() {

        long pairs = JourneyToTheMoon.journeyToMoon(500, buildTestCase6());

        assertThat(pairs).isEqualTo(43723);
    }

    @Test()
    @Timeout(value = 300, unit = TimeUnit.MILLISECONDS)
    void should_work_for_test_case7() {

        long pairs = JourneyToTheMoon.journeyToMoon(100000, new int[][]{{1, 2}, {3, 4}});

        assertThat(pairs).isEqualTo(4999949998L);
    }

    private static int[][] buildTestCase5(){
        String astronautsPair = "0 11\n" +
                "2 4\n" +
                "2 95\n" +
                "3 48\n" +
                "4 85\n" +
                "4 95\n" +
                "5 67\n" +
                "5 83\n" +
                "5 42\n" +
                "6 76\n" +
                "9 31\n" +
                "9 22\n" +
                "9 55\n" +
                "10 61\n" +
                "10 38\n" +
                "11 96\n" +
                "11 41\n" +
                "12 60\n" +
                "12 69\n" +
                "14 80\n" +
                "14 99\n" +
                "14 46\n" +
                "15 42\n" +
                "15 75\n" +
                "16 87\n" +
                "16 71\n" +
                "18 99\n" +
                "18 44\n" +
                "19 26\n" +
                "19 59\n" +
                "19 60\n" +
                "20 89\n" +
                "21 69\n" +
                "22 96\n" +
                "22 60\n" +
                "23 88\n" +
                "24 73\n" +
                "27 29\n" +
                "30 32\n" +
                "31 62\n" +
                "32 71\n" +
                "33 43\n" +
                "33 47\n" +
                "35 51\n" +
                "35 75\n" +
                "37 89\n" +
                "37 95\n" +
                "38 83\n" +
                "39 53\n" +
                "41 84\n" +
                "42 76\n" +
                "44 85\n" +
                "45 47\n" +
                "46 65\n" +
                "47 49\n" +
                "47 94\n" +
                "50 55\n" +
                "51 99\n" +
                "53 99\n" +
                "56 78\n" +
                "66 99\n" +
                "71 78\n" +
                "73 98\n" +
                "76 88\n" +
                "78 97\n" +
                "80 90\n" +
                "83 95\n" +
                "85 92\n" +
                "88 99\n" +
                "88 94";
        return getAstronauts(astronautsPair);
    }

    private static int[][] buildTestCase6(){
        String astronautsPair = "1 426\n" +
                "1 117\n" +
                "2 261\n" +
                "3 493\n" +
                "4 282\n" +
                "4 164\n" +
                "4 455\n" +
                "5 116\n" +
                "6 139\n" +
                "7 288\n" +
                "7 428\n" +
                "8 71\n" +
                "10 357\n" +
                "10 55\n" +
                "11 456\n" +
                "12 71\n" +
                "13 27\n" +
                "13 324\n" +
                "14 258\n" +
                "14 15\n" +
                "15 243\n" +
                "15 173\n" +
                "16 193\n" +
                "16 258\n" +
                "16 74\n" +
                "16 433\n" +
                "16 350\n" +
                "16 61\n" +
                "16 62\n" +
                "17 104\n" +
                "18 418\n" +
                "18 268\n" +
                "18 50\n" +
                "19 471\n" +
                "19 189\n" +
                "19 335\n" +
                "20 25\n" +
                "20 435\n" +
                "21 160\n" +
                "21 233\n" +
                "21 197\n" +
                "22 177\n" +
                "22 114\n" +
                "22 260\n" +
                "23 59\n" +
                "23 78\n" +
                "25 113\n" +
                "25 260\n" +
                "26 217\n" +
                "27 118\n" +
                "28 136\n" +
                "28 324\n" +
                "28 365\n" +
                "28 87\n" +
                "30 224\n" +
                "31 51\n" +
                "32 433\n" +
                "32 407\n" +
                "33 133\n" +
                "34 298\n" +
                "34 226\n" +
                "34 95\n" +
                "35 129\n" +
                "35 289\n" +
                "37 335\n" +
                "38 107\n" +
                "38 203\n" +
                "38 365\n" +
                "38 55\n" +
                "39 333\n" +
                "39 127\n" +
                "40 104\n" +
                "40 347\n" +
                "41 329\n" +
                "41 378\n" +
                "41 363\n" +
                "41 87\n" +
                "44 190\n" +
                "44 351\n" +
                "45 216\n" +
                "46 52\n" +
                "47 148\n" +
                "47 277\n" +
                "48 444\n" +
                "48 323\n" +
                "48 356\n" +
                "49 362\n" +
                "49 350\n" +
                "50 115\n" +
                "51 153\n" +
                "51 201\n" +
                "52 389\n" +
                "53 293\n" +
                "53 174\n" +
                "54 160\n" +
                "55 417\n" +
                "56 431\n" +
                "58 418\n" +
                "58 391\n" +
                "59 71\n" +
                "60 121\n" +
                "60 262\n" +
                "61 404\n" +
                "61 101\n" +
                "61 78\n" +
                "62 481\n" +
                "62 211\n" +
                "62 94\n" +
                "62 479\n" +
                "63 357\n" +
                "64 268\n" +
                "65 363\n" +
                "65 101\n" +
                "65 117\n" +
                "65 293\n" +
                "67 462\n" +
                "67 335\n" +
                "68 136\n" +
                "68 464\n" +
                "69 259\n" +
                "69 403\n" +
                "69 415\n" +
                "70 304\n" +
                "70 137\n" +
                "72 176\n" +
                "72 123\n" +
                "72 395\n" +
                "73 386\n" +
                "73 307\n" +
                "74 400\n" +
                "74 136\n" +
                "75 360\n" +
                "76 249\n" +
                "76 252\n" +
                "77 464\n" +
                "77 203\n" +
                "77 197\n" +
                "77 383\n" +
                "78 243\n" +
                "78 444\n" +
                "79 242\n" +
                "80 472\n" +
                "81 160\n" +
                "81 153\n" +
                "81 451\n" +
                "81 254\n" +
                "83 227\n" +
                "83 350\n" +
                "84 346\n" +
                "84 237\n" +
                "84 342\n" +
                "85 337\n" +
                "86 109\n" +
                "87 355\n" +
                "88 300\n" +
                "88 325\n" +
                "88 327\n" +
                "89 354\n" +
                "89 272\n" +
                "89 370\n" +
                "89 220\n" +
                "89 93\n" +
                "89 158\n" +
                "90 454\n" +
                "91 297\n" +
                "92 486\n" +
                "92 175\n" +
                "93 394\n" +
                "93 409\n" +
                "95 448\n" +
                "95 294\n" +
                "95 366\n" +
                "95 309\n" +
                "95 442\n" +
                "96 264\n" +
                "96 464\n" +
                "96 269\n" +
                "96 263\n" +
                "98 248\n" +
                "98 354\n" +
                "98 444\n" +
                "98 342\n" +
                "101 305\n" +
                "101 277\n" +
                "102 217\n" +
                "103 471\n" +
                "104 162\n" +
                "105 153\n" +
                "105 124\n" +
                "106 482\n" +
                "107 152\n" +
                "107 421\n" +
                "107 158\n" +
                "107 437\n" +
                "109 321\n" +
                "109 447\n" +
                "110 424\n" +
                "110 276\n" +
                "110 372\n" +
                "110 333\n" +
                "111 281\n" +
                "111 331\n" +
                "113 184\n" +
                "113 244\n" +
                "115 404\n" +
                "117 393\n" +
                "117 430\n" +
                "117 379\n" +
                "117 189\n" +
                "117 158\n" +
                "118 458\n" +
                "118 213\n" +
                "118 478\n" +
                "119 345\n" +
                "119 338\n" +
                "120 153\n" +
                "121 201\n" +
                "121 177\n" +
                "123 388\n" +
                "123 304\n" +
                "123 406\n" +
                "123 280\n" +
                "123 347\n" +
                "124 262\n" +
                "124 397\n" +
                "124 147\n" +
                "124 213\n" +
                "124 283\n" +
                "125 378\n" +
                "125 460\n" +
                "126 263\n" +
                "127 312\n" +
                "128 251\n" +
                "128 357\n" +
                "131 358\n" +
                "132 496\n" +
                "132 409\n" +
                "132 498\n" +
                "133 432\n" +
                "134 334\n" +
                "134 455\n" +
                "135 282\n" +
                "135 435\n" +
                "136 369\n" +
                "137 176\n" +
                "138 390\n" +
                "138 142\n" +
                "139 336\n" +
                "139 154\n" +
                "139 199\n" +
                "140 418\n" +
                "141 469\n" +
                "145 242\n" +
                "146 438\n" +
                "147 252\n" +
                "147 238\n" +
                "149 436\n" +
                "149 231\n" +
                "150 476\n" +
                "151 395\n" +
                "151 340\n" +
                "152 476\n" +
                "152 491\n" +
                "152 431\n" +
                "153 452\n" +
                "153 484\n" +
                "154 418\n" +
                "154 252\n" +
                "156 297\n" +
                "158 208\n" +
                "158 316\n" +
                "161 499\n" +
                "161 484\n" +
                "161 471\n" +
                "162 366\n" +
                "163 345\n" +
                "164 379\n" +
                "165 242\n" +
                "165 421\n" +
                "167 389\n" +
                "167 286\n" +
                "168 320\n" +
                "168 361\n" +
                "168 466\n" +
                "168 432\n" +
                "169 389\n" +
                "170 273\n" +
                "172 472\n" +
                "172 409\n" +
                "173 242\n" +
                "175 411\n" +
                "175 310\n" +
                "176 224\n" +
                "176 297\n" +
                "176 202\n" +
                "176 465\n" +
                "176 373\n" +
                "178 459\n" +
                "178 229\n" +
                "178 181\n" +
                "179 332\n" +
                "180 358\n" +
                "182 473\n" +
                "182 211\n" +
                "182 455\n" +
                "183 384\n" +
                "183 424\n" +
                "183 419\n" +
                "184 296\n" +
                "184 378\n" +
                "184 264\n" +
                "185 324\n" +
                "187 473\n" +
                "187 230\n" +
                "188 264\n" +
                "188 242\n" +
                "188 414\n" +
                "191 344\n" +
                "191 264\n" +
                "191 276\n" +
                "192 364\n" +
                "192 436\n" +
                "193 194\n" +
                "193 301\n" +
                "194 339\n" +
                "195 327\n" +
                "196 480\n" +
                "196 265\n" +
                "196 466\n" +
                "196 240\n" +
                "198 403\n" +
                "199 248\n" +
                "199 492\n" +
                "200 207\n" +
                "201 459\n" +
                "202 404\n" +
                "202 429\n" +
                "203 273\n" +
                "204 343\n" +
                "205 361\n" +
                "205 419\n" +
                "206 443\n" +
                "206 334\n" +
                "209 365\n" +
                "210 223\n" +
                "211 223\n" +
                "212 298\n" +
                "214 254\n" +
                "215 288\n" +
                "215 486\n" +
                "217 331\n" +
                "217 366\n" +
                "219 408\n" +
                "219 445\n" +
                "219 237\n" +
                "221 397\n" +
                "223 423\n" +
                "224 343\n" +
                "225 418\n" +
                "226 389\n" +
                "226 295\n" +
                "227 341\n" +
                "229 459\n" +
                "230 497\n" +
                "230 450\n" +
                "230 348\n" +
                "231 391\n" +
                "233 310\n" +
                "234 281\n" +
                "234 361\n" +
                "238 473\n" +
                "239 429\n" +
                "239 461\n" +
                "240 274\n" +
                "242 379\n" +
                "243 425\n" +
                "243 357\n" +
                "244 448\n" +
                "244 437\n" +
                "247 489\n" +
                "248 405\n" +
                "249 440\n" +
                "250 456\n" +
                "250 314\n" +
                "250 383\n" +
                "251 468\n" +
                "253 360\n" +
                "253 463\n" +
                "255 499\n" +
                "257 290\n" +
                "257 307\n" +
                "258 480\n" +
                "258 449\n" +
                "259 481\n" +
                "260 481\n" +
                "260 455\n" +
                "261 439\n" +
                "264 485\n" +
                "266 401\n" +
                "268 409\n" +
                "268 340\n" +
                "273 362\n" +
                "275 420\n" +
                "276 279\n" +
                "277 467\n" +
                "277 316\n" +
                "280 386\n" +
                "281 305\n" +
                "283 399\n" +
                "288 365\n" +
                "289 490\n" +
                "290 458\n" +
                "291 458\n" +
                "291 339\n" +
                "294 345\n" +
                "294 316\n" +
                "295 379\n" +
                "296 308\n" +
                "298 305\n" +
                "299 353\n" +
                "299 420\n" +
                "300 352\n" +
                "300 340\n" +
                "303 306\n" +
                "306 456\n" +
                "306 417\n" +
                "306 356\n" +
                "308 459\n" +
                "310 392\n" +
                "310 316\n" +
                "311 337\n" +
                "311 390\n" +
                "313 495\n" +
                "314 356\n" +
                "314 402\n" +
                "316 444\n" +
                "317 444\n" +
                "320 407\n" +
                "321 444\n" +
                "324 465\n" +
                "326 410\n" +
                "326 494\n" +
                "327 392\n" +
                "329 386\n" +
                "329 485\n" +
                "332 398\n" +
                "333 360\n" +
                "335 346\n" +
                "337 416\n" +
                "338 380\n" +
                "339 398\n" +
                "339 407\n" +
                "340 388\n" +
                "345 497\n" +
                "345 481\n" +
                "348 374\n" +
                "351 359\n" +
                "353 429\n" +
                "354 406\n" +
                "356 371\n" +
                "357 438\n" +
                "357 378\n" +
                "363 394\n" +
                "364 472\n" +
                "364 451\n" +
                "369 453\n" +
                "370 429\n" +
                "371 436\n" +
                "371 462\n" +
                "373 482\n" +
                "378 448\n" +
                "379 450\n" +
                "382 416\n" +
                "382 427\n" +
                "382 468\n" +
                "386 457\n" +
                "386 435\n" +
                "388 452\n" +
                "395 490\n" +
                "396 492\n" +
                "399 487\n" +
                "400 416\n" +
                "400 462\n" +
                "408 480\n" +
                "411 438\n" +
                "412 437\n" +
                "414 426\n" +
                "414 423\n" +
                "416 436\n" +
                "416 431\n" +
                "417 488\n" +
                "417 483\n" +
                "419 477\n" +
                "436 497\n" +
                "438 453\n" +
                "445 491\n" +
                "456 465\n" +
                "456 476\n" +
                "458 470\n" +
                "466 488";
        return getAstronauts(astronautsPair);
    }

    private static int[][] getAstronauts(String astronautsPair) {
        String[] pair = astronautsPair.split("\n");
        int[][] result = new int[pair.length][2];
        for (int i = 0; i < pair.length; i++) {
            String[] astronauts = pair[i].split(" ");
            result[i][0] = Integer.parseInt(astronauts[0]);
            result[i][1] = Integer.parseInt(astronauts[1]);
        }
        return result;
    }
}