package org.grails.plugins.coffeescript

import org.springframework.core.io.ClassPathResource

class CoffeeScriptEngineTests extends grails.test.GrailsUnitTestCase {

    def coffeeScriptEngine

    void setUp() {
        coffeeScriptEngine = new CoffeeScriptEngine()
    }

    void testCompile() {
        def input = (new ClassPathResource('org/grails/plugins/coffeeScript/example.coffee', getClass().classLoader)).file
        def expectedResult = (new ClassPathResource('org/grails/plugins/coffeeScript/example.js', getClass().classLoader)).file
        def output = coffeeScriptEngine.compile(input)
        assert output.contains('number = 42;'): "Output $output"
        assertEquals(expectedResult.text, output)
    }
}

