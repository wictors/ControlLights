@Parser(
        className = "parser.ExpressionParser",
        mainNode = "program.Program",
        tokens = {
                @TokenDef(name = "COLON", regexp = "[:]"),
                @TokenDef(name = "NUMBER", regexp = "[0-9]+"),
                @TokenDef(name = "HEX", regexp = "[#0-9a-z]+")
        },
        skips = {
                @Skip(" "),
                @Skip("\\t"),
                @Skip("\\n"),
                @Skip("\\r")
        }
)
package program.Model;

import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;