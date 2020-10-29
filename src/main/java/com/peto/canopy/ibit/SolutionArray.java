package com.peto.canopy.ibit;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class SolutionArray {
    public static void main(String[] args) {
        System.out.println(getRow(8));
    }

    private static ArrayList<ArrayList<Integer>> solvePascalTriangle(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (A == 0) {
            return result;
        }
        result.add(new ArrayList<>(Collections.singletonList(1)));
        for (int i = 1; i < A; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            ArrayList<Integer> prevRow = result.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j - 1 < 0 || j == i) {
                    row.add(1);
                    continue;
                }
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            result.add(row);
        }
        return result;
    }

    private static ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= A; i++) {
            int num = (A + 1 - i) * res.get(i - 1) / i;
            res.add(num);
        }
        return res;
    }

    private static void testMissingPositive() {
        //        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(417, 929, 845, 462, 675, 175, 73, 867, 14, 201, 777, 407, 80, 882, 785, 563, 209, 261, 776, 362, 730, 74, 649, 465, 353, 801, 503, 154, 998, 286, 520, 692, 68, 805, 835, 210, 819, 341, 564, 215, 984, 643, 381, 793, 726, 213, 866, 706, 97, 538, 308, 797, 883, 59, 328, 743, 694, 607, 729, 821, 32, 672, 130, 13, 76, 724, 384, 444, 884, 192, 917, 75, 551, 96, 418, 840, 235, 433, 290, 954, 549, 950, 21, 711, 781, 132, 296, 44, 439, 164, 401, 505, 923, 136, 317, 548, 787, 224, 23, 185, 6, 350, 822, 457, 489, 133, 31, 830, 386, 671, 999, 255, 222, 944, 952, 637, 523, 494, 916, 95, 734, 908, 90, 541, 470, 941, 876, 264, 880, 761, 535, 738, 128, 772, 39, 553, 656, 603, 868, 292, 117, 966, 259, 619, 836, 818, 493, 592, 380, 500, 599, 839, 268, 67, 591, 126, 773, 635, 800, 842, 536, 668, 896, 260, 664, 506, 280, 435, 618, 398, 533, 647, 373, 713, 745, 478, 129, 844, 640, 886, 972, 62, 636, 79, 600, 263, 52, 719, 665, 376, 351, 623, 276, 66, 316, 813, 663, 831, 160, 237, 567, 928, 543, 508, 638, 487, 234, 997, 307, 480, 620, 890, 216, 147, 271, 989, 872, 994, 488, 291, 331, 8, 769, 481, 924, 166, 89, 824, -4, 590, 416, 17, 814, 728, 18, 673, 662, 410, 727, 667, 631, 660, 625, 683, 33, 436, 930, 91, 141, 948, 138, 113, 253, 56, 432, 744, 302, 211, 262, 968, 945, 396, 240, 594, 684, 958, 343, 879, 155, 395, 288, 550, 482, 557, 826, 598, 795, 914, 892, 690, 964, 981, 150, 179, 515, 205, 265, 823, 799, 190, 236, 24, 498, 229, 420, 753, 936, 191, 366, 935, 434, 311, 920, 167, 817, 220, 219, 741, -2, 674, 330, 909, 162, 443, 412, 974, 294, 864, 971, 760, 225, 681, 689, 608, 931, 427, 687, 466, 894, 303, 390, 242, 339, 252, 20, 218, 499, 232, 184, 490, 4, 957, 597, 477, 354, 677, 691, 25, 580, 897, 542, 186, 359, 346, 409, 655, 979, 853, 411, 344, 358, 559, 765, 383, 484, 181, 82, 514, 582, 593, 77, 228, 921, 348, 453, 274, 449, 106, 657, 783, 782, 811, 333, 305, 784, 581, 746, 858, 249, 479, 652, 270, 429, 614, 903, 102, 378, 575, 119, 196, 12, 990, 356, 277, 169, 70, 518, 282, 676, 137, 622, 616, 357, 913, 161, 3, 589, 327));
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(948, 20, 84, 710, 471, 606, 995, 581, -4, 428, 149, 832, 740, 943, 450, 974, 829, 721, 821, 476, 763, 4, 523, 937, 814, 624, 935, 87, 127, 816, 239, 33, 561, 999, 904, 282, 844, 923, 750, 551, 432, 9, 373, 387, 114, 376, 265, 801, 228, 454, 474, 764, 268, 680, 472, 431, 133, 785, 752, 643, 441, 151, 969, 395, 437, 94, 259, 973, 535, 272, 456, 546, 79, 677, 0, 109, 522, 295, 466, 956, 723, 157, 772, 865, 997, 771, 922, 980, 567, 939, 651, 478, 852, 926, 913, 494, 882, 207, 915, 645, 754, 385, 874, 554, 706, 722, 10, 374, 96, 647, 280, 418, 737, 538, 867, 850, 600, 23, 730, 742, 224, 511, 361, 251, 809, 907, 271, 319, 866, 848, 594, 566, 113, 211, 334, 644, 826, 430, 929, 603, 165, 147, 788, 529, 539, 633, 275, 602, 544, 540, 853, 123, -1, 443, 942, 386, 68, 465, 782, 250, 458, 174, 70, 919, 462, 347, 26, 589, 880, 648, 237, 294, 641, 707, 516, 507, 802, 989, 779, 519, 62, 619, 584, 358, 362, 277, 43, 198, 467, 625, 611, 212, 468, 767, 778, 173, 791, 331, 11, 461, 572, 97, 902, 558, 413, 28, 179, 370, 842, 568, 500, 311, 550, 464, 345, 411, 274, 181, 396, 339, 39, 760, 575, 327, 889, 579, 840, 734, 254, 934, 532, 29, 622, 780, 73, 479, 322, 2, 599, 227, 685, 65, 510, 716, 289, 912, 574, 262, 916, 924, 304, 57, 353, 40, 341, 521, 131, 307, 526, 398, 225, 63, 776));

//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(894, 669, 852, 722, 778, 169, 247, 927, 875, 858, 396, 760, 318, 409, 640, 976, 419, 600, 711, 610, 864, 655, 859, 567, 7, 487, 953, 632, 544, 158, 53, 919, 45, 699, 493, 414, 586, 460, 339, 540, 12, 948, 515, 16, 116, 772, 529, 606, 684, 214, 724, 811, 925, 703, 454, 592, 330, 143, 41, 401, 570, 326, 885, 943, 836, 252, 119, 773, 768, 447, 581, 237, 380, 182, 457, 868, 667, 109, 702, 692, 542, 517, 966, 583, 983, 273, 641, 691, 985, 115, 574, 216, 372, 298, 411, 784, 95, 251, 389, 354, 964, 430, 991, 799, 824, 826, 714, 238, 967, 977, 291, 545, 355, 287, 425, 305, 118, 902, 479, 388, 19, 61, 301, 782, 688, 893, 673, 195, 971, 693, 797, 996, 3, 314, 353, 103, 391, 905, 316, 734, 54, 939, 648, 526, 448, 255, 690, 114, 715, 148, 376, 878, 483, 408, 804, 585, 79, 644, 621, 221, 345));
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(581, 366, 930, 829, 192, 275, 575, 654, 937, 774, 864, 910, 519, 685, 86, 841, 595, 954, 1000, 720, 925, 400, 897, 351, 46, 877, 733, 793, 971, 577, 380, 60, 166, 797, 744, 231, 732, 642, 410, 421, 53, 65, 422, 301, 798, 911, 698, 935, 525, 682, 828, 25, 250, 356, 452, 200, 134, 293, 514, 14, 544, 906, 467, 101, 783, 786, 803, 210, 211, 880, 172, 485, 639, 66, 724, 920, 764, 345, 612, 520, 888, 529, 368, 56, 238, 770, 615, 159, 314, 740, 973, 404, 490, 267, 338, 19, 989, 271, 425, 865, 568, 686, 439, 480, 943, 904, 276, 878, 762, 120, 29, 814, 712, 191, 500, 161, 846, 889, 251, 635, 258, 941, 396, 677, 627, 702, 282, 503, 497, 801, 184, 162, 158, 51, 541, 749, 336, 372, 540, 629, 647, 824, 548, 700, 434, 928, 845, 157, 360, 77, 982, 791, 340, 8, 155, 182, 551, 476, 725, 709, 921, 761, 823, 730, 505, 856, 269, 257, 589, 866, 125, 765, 608, 643, 265, 67, 76, 553, 462, 986, 822, 441, 779, 967, 616, 944, 645, 225, 534, 852, 283, -1, 657, 205, 907, 813, 102, 96, 692, 851, 12, 408, 672, 847, 26, 651, 216, 962, 689, 411, 156, 628, 659, 715, 295, 707, 209, 178, 902, 337, 428, 555, 494, 5, 83, 722, 137, 957, 229, 92, 247, 696, 450, 528, 976, 323, 631, 914, 795, 346, 604, 539, 585, 763, 261, 286, 387, 488, 226, 349, 546, 429, 486, 699, 543, 32, 590, 810, 901, 680, 405, 126, 946, 133, 264, 508, 90, 636, 655, 208, 167, 796, 13, 311, 334, 228, 427, 552, 839, 253, 88, 754, 994, 243, 147, 507, 154, 903, 723, 22, 296, 924, 710, 717, 179, 979, 394, 767, 197, 755, 892, 444, 284, 958, 479, 818, 557, 392, 114, 776, 583, 926, 532, 24, 203, 719, 122, 186, 983, 919, 637, 775, 695, 820, 652, 50, 501, 727, 991, 859, 757, 2, 956, 938, 691, 128, 68, 565, 475, 968, 509, 236, 100, 536, 457, 138, 320, 726, 614, 950, 697, 735, 649, 54, 807, 862, 554, 379, 849, 912, 308, 491, 11, 656, 412, 891, 587, 124, 562, 129, 526, 466, 857, 419, 55, 738, 934, 693, 790, 294, 326, 952, 808, 185, 312, 598, 135, 73, 242, 868));
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(110, 483, 137, 881, 946, 231, 378, 449, 68, 518, 476, 898, 685, 384, 839, 553, 304, 689, 467, 292, 414, 679, 301, 30, 457, 300, 93, 427, 619, 439, 4, 348, 714, 966, 142, 538, 484, 827, 237, 447, 442, 133, 771, 578, 190, 782, 182, 23, 192, 177, 164, 276, 273, 45, 624, 12, 354, 938, 472, 899, 42, 612, 813, 386, 380, 63, 136, 589, 334, 349, 757, 999, 526, 156, 803, 991, 961, 535, 297, 336, 409, 59, 558, 678, 755, 720, 88, 906, 571, 770, 673, 581, 399, 868, 446, 123, 707, 643, 548, 226, 854, 830, 423, 621, 14, 767, 801, 651, 932, 492, 462, 321, 250, 591, 208, 862, 413, 418, 724, 746, 388, 925, 882, 808, 543, 171, 737, 994, 283, 950, 528, 443, 853, 671, 699, 19, 344, 365, 134, 818, 531, 48, 464, 124, 377, 379, 792, 387, 11, 796, 159, 65, 842, 109, 631, 600, 987, -3, 263, 28, 833, 779, 100, 73, 790, 179, 889, 557, 887, 455, 502, 511, 907, 686, 713, 864, 271, 372, 850, 534, 347, 649, 21, 169, 712, 435, 1, 222, 509, 866, 628, 604, 885, 385, 896, 498, 964, 598, 508, 575, 893, 294, 520, 918, 729, 789, 772, 660, 87, 569, 677, 602, 962, 217, 69, 648, 72, 331, 749, 637, 180, 489, 733, 481, 393, 40, 274, 320, 113, 930, 633, 516, 878, 835, 754, 126, 15, 593, 338, 494, 972, 603, 34, 739, 947, 592, 886, 583, 127, 172, 675, 975, 232, 394, 763, 92, 512, 616, 983, 856, 955, 166, 157, 608, 218, 56, 66, 696, 310, 933, 185, 563, 647, 960, 323, 727, 471, 397, 367, 582, 223, 369, 759, 706, 35, 588, 478, 317, 564, 768, 904, 149, 202, 165, 695, 985, 731, 486, 312, 561, 466, 197, 245, 980, 979, 620, 774, 438, 193, 146, 653, 468, 963, 485, 178, 29, 434, 272, 296, 700, 549, 181, 586, 595, 410, 108, 91, 640, 175, 750, 490, 20, 101, 879, 74, 798, 910, 611, 187, 286, 997, 138, 488, 901, 154, 267, 403, 122, 572, 787, 942, 391, 525, 176, 383, 1000, 458, 24, 780, 691, 738, 151, 170, 351, 441, 776, 453, 590, 545, 139, 859, 461, 970, 491, 785, 969, 670, 570, 219, 99, 353, 723, 470, 716, 249, 115, 680, 501, 128, 851, 9, 120, 256, 820, 114, 416, 329));

//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 4, -1, 1));

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1));
        System.out.println(firstMissingPositive(A));
    }

    private static int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            while (A.get(i) != i + 1) {
                int x = A.get(i);
                if (x <= 0 || x >= n) {
                    break;
                }

                //handle duplicate elements
                if (x == A.get(x - 1)) {
                    break;
                }
                // swap elements
                A.set(i, A.get(x - 1));
                A.set(x - 1, x);
            }
        }

        for (int i = 0; i < n; i++) {
            if (A.get(i) != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    private static void testLargestNumber() {
        List<Integer> A = Arrays.asList(8, 89);
        System.out.println(largestNumber(A));
    }

    private static void testNobleInteger() {
        System.out.println(findNobleInteger(new ArrayList<>(Arrays.asList(0))));
        // -6, -4, -2, -1, 0
    }

    private static void testRepeatedNumber() {

    }

    private static void testPlusOne() {
        System.out.println(plusOne(new ArrayList<>(Arrays.asList(0, 0, 3, 7, 6, 4, 0, 5, 5, 5))));
    }

    private static void testSpiralOrderMatrix() {
        ArrayList<Integer> i1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> i2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        ArrayList<Integer> i3 = new ArrayList<>(Arrays.asList(9, 10, 11, 12));
        ArrayList<Integer> i4 = new ArrayList<>(Arrays.asList(13, 14, 15, 16));
        ArrayList<Integer> i5 = new ArrayList<>(Arrays.asList(17, 18, 19, 20));

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(i1);
        matrix.add(i2);
        matrix.add(i3);
        matrix.add(i4);
        matrix.add(i5);

        System.out.println(spiralOrder(matrix));
    }

    public static String largestNumber(final List<Integer> A) {
        List<String> B = A.stream().map(s -> Integer.toString(s)).collect(Collectors.toList());

        B.sort((s1, s2) -> {
            String r1 = s1 + s2;
            String r2 = s2 + s1;
            return new BigInteger(r2).compareTo(new BigInteger(r1));
        });

        StringBuilder sb = new StringBuilder();
        for (String x : B) {
            sb.append(x);
        }
        return sb.toString().replaceFirst("^0+(?!$)", "");
    }

    public enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();

        int maxElement = m * n;
        Direction direction = Direction.RIGHT;
        int row;
        int column;
        int columnMax = n;
        int rowMax = m;
        int rowMin = 0;
        int columnMin = 0;
        while (maxElement > 0) {
            if (direction == Direction.RIGHT) {
                List<Integer> xList = A.get(rowMin);
                for (column = columnMin; column < columnMax; column++) {
                    maxElement--;
                    result.add(xList.get(column));
                }
                rowMin++;
                direction = Direction.DOWN;
                continue;
            }
            if (direction == Direction.DOWN) {
                for (row = rowMin; row < rowMax; row++) {
                    maxElement--;
                    result.add(A.get(row).get(columnMax - 1));
                }
                direction = Direction.LEFT;
                columnMax--;
                continue;
            }
            if (direction == Direction.LEFT) {
                List<Integer> xList = A.get(rowMax - 1);
                for (column = columnMax - 1; column >= columnMin; column--) {
                    maxElement--;
                    result.add(xList.get(column));
                }
                rowMax--;
                direction = Direction.UP;
                continue;
            }
            if (direction == Direction.UP) {
                for (row = rowMax - 1; row >= rowMin; row--) {
                    maxElement--;
                    result.add(A.get(row).get(columnMin));
                }
                columnMin++;
                direction = Direction.RIGHT;
            }
        }
        return result;
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();
        int pos = n - 1;
        int carry = 0;
        int sum;
        for (int i = pos; i >= 0; i--) {
            if (i == n - 1) {
                sum = A.get(i) + 1;
                carry = sum > 9 ? 1 : 0;
                result.add(sum % 10);
                continue;
            }

            sum = A.get(i) + carry;
            carry = sum > 9 ? 1 : 0;
            result.add(sum % 10);
        }

        if (carry > 0) {
            result.add(carry);
        }
        Collections.reverse(result);
        int startIdx = 0;
        for (Integer aResult : result) {
            if (aResult == 0) {
                startIdx++;
            } else {
                break;
            }
        }

        return new ArrayList<>(result.subList(startIdx, result.size()));
    }

    public static int repeatedNumber(final List<Integer> A) {
        /*HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        for (Integer i : A) {
            integerHashMap.put(i, integerHashMap.containsKey(i) ? integerHashMap.get(i) + 1 : 1);
        }

        for (Map.Entry<Integer, Integer> entries : integerHashMap.entrySet()) {
            if (entries.getValue() > 1) {
                return entries.getKey();
            }
        }
        return -1;*/

        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return A.size() + 1;
    }

    private static int findNobleInteger(ArrayList<Integer> A) {
        A.sort(Comparator.naturalOrder());
        for (int i = 0; i < A.size(); i++) {
            if (i + 1 <= A.size() - 1 && A.get(i) < A.get(i + 1) && A.get(i) == (A.size() - i - 1)) {
                return 1;
            }
            if (A.get(A.size() - 1) == 0) {
                return 1;
            }
        }
        return -1;
    }
}
