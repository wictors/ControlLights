@Parser(
        className = "parser.SpeechParser",
        mainNode = "language.model.Speech",
        tokens = {
                @TokenDef(name = "NAME", regexp = "[a-z]+")
        },
        skips = {
                @Skip(" "),
                @Skip("\\t"),
                @Skip("\\n"),
                @Skip("\\r")
        }
)
package language.model;

import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
