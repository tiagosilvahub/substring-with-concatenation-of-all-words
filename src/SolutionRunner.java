package src;

import src.solutions.SlidingWindow;
import src.solutions.Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SolutionRunner {
    public static void main(String[] args) {
        Solution[] solutions =
                new Solution[]{
                        new SlidingWindow(),
                };

        // add test cases
        var input = new String[][][]{
                new String[][]{
                        new String[] {
                                "wordgoodgoodgoodbestword"
                        },
                        new String[]{
                                "word","good","best","word"
                        }
                },
                new String[][]{
                        new String[] {
                                "barfoothefoobarman"
                        },
                        new String[]{
                                "foo","bar"
                        }
                },
                new String[][]{
                        new String[] {
                                ""
                        },
                        new String[]{
                                ""
                        }
                },
                new String[][]{
                        new String[] {
                                "a"
                        },
                        new String[]{
                                ""
                        }
                },
                new String[][]{
                        new String[] {
                                "aaabbbc"
                        },
                        new String[]{
                                "a","a","b","b","c"
                        }
                },
                new String[][]{
                        new String[] {
                                "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel"
                        },
                        new String[]{
                                "dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"
                        }
                },
        };

        List<Integer> result;
        int errors = 0;
        int nTestCases = input.length;
        List<List<Integer>> output = new LinkedList<>();
        output.add(Collections.emptyList());
        output.add(Arrays.asList(0,9));
        output.add(Collections.emptyList());
        output.add(Collections.emptyList());
        output.add(Collections.emptyList());
        output.add(Collections.singletonList(935));

        assert(output.size() == nTestCases);

        for (Solution s : solutions) {
            for (int i = 0; i < nTestCases; i++) {
                // put input arguments into solution
                result = s.findSubstring(input[i][0][0], input[i][1]);
                // implement equals if needed
                if( !result.equals(output.get(i))) {
                    System.out.println("Solution " + s.getClass().getCanonicalName() + " wrong for input " + Arrays.deepToString(input[i]));
                    System.out.println("Expected: " + output.get(i) + " but got: " + result);
                    System.out.println();
                    errors++;
                }
            }
        }
        printResults(errors, nTestCases);
    }

    private static void printResults(int errors, int nTestCases) {
        if(errors == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(nTestCases - errors + " tests passed.");
        }
        System.out.println(errors + " tests failed.");
        System.out.println((0.0 + nTestCases - errors) / nTestCases * 100  + "% of tests passed.");
    }
}

