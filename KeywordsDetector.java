public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
                "Our product will transform the market",
                "Programming is both painful and engaging",
                "This has nothing to do with machine learning",
                "We need to leverage our core competencies",
                "Let's talk about data and algorithms",
                "Chatbots are great but must be used carefully",
                "This blockchain-based solution will disrupt the industry",
                "The team showed great Synergy in the last project",
                "Use simple words without hype and fluff",
                "Our new technology presents a significant paradigm shift",
                "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business
        // presentations
        String[] keywords = { "synergy", "disrupt", "leverage", "Paradigm", "transform" };
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        if (sentences.length == 0 || keywords.length == 0) {
            System.out.println("");
        } else {
            String[] lowerCaseSentences = new String[sentences.length];
            String[] lowerCaseKeywords = new String[keywords.length];
            // Convert the sentences array to lowercase versions of each sentence
            for (int i = 0; i < sentences.length; i++) {
                String lowerCaseSentence = "";
                for (int j = 0; j < sentences[i].length(); j++) {
                    if (sentences[i].charAt(j) < 65 || sentences[i].charAt(j) > 90) {
                        lowerCaseSentence += sentences[i].charAt(j);
                    } else {
                        lowerCaseSentence += (char) ((int) (sentences[i].charAt(j)) + 32);
                    }
                }
                lowerCaseSentences[i] = lowerCaseSentence;
            }
            // Convert the keywords array to lowercase versions of each keywords
            for (int i = 0; i < keywords.length; i++) {
                String lowerCaseKeyword = "";
                for (int j = 0; j < keywords[i].length(); j++) {
                    if (keywords[i].charAt(j) < 65 || keywords[i].charAt(j) > 90) {
                        lowerCaseKeyword += keywords[i].charAt(j);
                    } else {
                        lowerCaseKeyword += (char) ((int) (keywords[i].charAt(j)) + 32);
                    }
                }
                lowerCaseKeywords[i] = lowerCaseKeyword;
            }
            // If a sentence contains one or more of the kewords, prints it.
            for (int i = 0; i < lowerCaseKeywords.length; i++) {
                for (int j = 0; j < lowerCaseSentences.length; j++) {
                    if (lowerCaseSentences[j].indexOf(lowerCaseKeywords[i]) != -1) {
                        System.out.println(sentences[j]);
                    }
                }
            }

        }
    }
}
