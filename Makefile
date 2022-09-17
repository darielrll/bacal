
test:
	./gradlew clean
	./gradlew test

md := "\n\
## Link to the problem\n\
 \n\
 - https://leetcode.com/problems/binary-search/\n\
 \n\
##### Difficulty Level (according to Leetcode)\n\
 \n\
 > Easy ( Array | Binary Search )\n\
 \n\
##### Resume of the problem:\n\
\n\
\n\
##### Notes\n\
  \n\
  EOF"

define MARKDOWN_BODY
'## Link to the problem\n\
\n\
- https://leetcode.com/problems/binary-search/\n\
\n\
##### Difficulty Level (according to Leetcode)\n\
\n\
> Easy ( Array | Binary Search )\n\
\n\
\n\
##### Resume of the problem:\
\n\
\n\
\n\
##### Notes\n'
endef

define SOLUTION_BODY
'package drll.problems.leetcode.solution;\n\
\n\
public class BinarySearch {\n\
\t    public int search(int[] nums, int target) {\n\
        return -1;\n\
    }\n\
}'
endef

prepareLeetCodeContest:
	mkdir -p "src/main/java/drll/problems/leetCodeContest"

	mkdir -p "src/main/java/drll/problems/leetCodeContest/problem1"
	touch "src/main/java/drll/problems/leetCodeContest/problem1/Problem1.md"
	@echo $(MARKDOWN_BODY) > "src/main/java/drll/problems/leetCodeContest/problem1/Problem1.md"

	mkdir -p "src/main/java/drll/problems/leetCodeContest/problem2"
	touch "src/main/java/drll/problems/leetCodeContest/problem2/Problem2.md"
	@echo $(MARKDOWN_BODY) > "src/main/java/drll/problems/leetCodeContest/problem2/Problem2.md"

	mkdir -p "src/main/java/drll/problems/leetCodeContest/problem3"
	touch "src/main/java/drll/problems/leetCodeContest/problem3/Problem3.md"
	@echo $(MARKDOWN_BODY) > "src/main/java/drll/problems/leetCodeContest/problem3/Problem3.md"

	mkdir -p "src/main/java/drll/problems/leetCodeContest/problem4"
	touch "src/main/java/drll/problems/leetCodeContest/problem4/Problem4.md"
	@echo $(MARKDOWN_BODY) > "src/main/java/drll/problems/leetCodeContest/problem4/Problem4.md"

