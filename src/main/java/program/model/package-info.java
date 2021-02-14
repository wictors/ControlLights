@Parser(
        className = "parser.ExpressionParser",
        mainNode = "program.Model.Program",
        tokens = {
                @TokenDef(name = "COLON", regexp = "[:]"),
                @TokenDef(name = "NUMBER", regexp = "[0-9]+"),
                @TokenDef(name = "HEX", regexp = "[#0-9a-z]+"),
                @TokenDef(name = "VARIABLE", regexp = "[a-z]+")
        },
        skips = {
                @Skip(" "),
                @Skip("\\t"),
                @Skip("\\n"),
                @Skip("\\r")
        }
)
package program.model;

import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;