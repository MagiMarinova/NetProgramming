regExps = {
"exercise_1": /[A-Z][a-z]+/,
"exercise_2": /088[1-9]{7}/,
"exercise_3": /[^01]+/,
"exercise_4": /^[a-zA-Z][\w.+]{2,13}$/,
"exercise_5": /^(?:[0-9]|(?:[1-9][0-9])|(?:[1-9][0-9][0-9])|(?:[1-1][0-4][0-9][0-9])|(?:1500))$/,
"exercise_6": /class=['"][\w+ ]+['"]/
};
cssSelectors = {
"exercise_1": "css>item>java",
"exercise_2": "css>different>different>java",
"exercise_3": "css>item>java>tag",
"exercise_4": "css>item#someId+item",
"exercise_5": "css>item>tag>java+java.class1",
"exercise_6": "css>item>item>item>item>item",
"exercise_7": "css>different>different#diffId2>java+java.diffClass",
"exercise_8": "css>item#someId"
};
