const path = require('path');
const {VueLoaderPlugin} = require('vue-loader');
const { VuetifyPlugin } = require('webpack-plugin-vuetify')


module.exports = {
    mode: 'development',
    devtool: 'source-map',
    entry: {
        taskBoard:path.join(__dirname, 'src', 'main', 'resources', 'static', 'TaskBoard', 'js', 'TaskBoard.js'),
        auth:path.join(__dirname, 'src', 'main', 'resources', 'static', 'Auth', 'js', 'Auth.js'),
    },
    devServer: {
        static: './dist',
        compress: true,
        port: 8001,
        allowedHosts: [
            'localhost:9000'
        ]
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {
                test: /\.css$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                ],
            },
            {
                test: /\.sass$/,
                use: [
                    {
                        loader: 'sass-loader',
                        // Requires sass-loader@^7.0.0
                        options: {
                            implementation: require('sass'),
                            fiber: require('fibers'),
                            indentedSyntax: true // optional
                        },
                        // Requires sass-loader@^8.0.0
                        options: {
                            implementation: require('sass'),
                            sassOptions: {
                                fiber: require('fibers'),
                                indentedSyntax: true // optional
                            },
                        },
                    },
                ],
            },
            {
                test: /\.sass$/,
                use: [
                    {
                        loader: 'sass-loader',
                        options: {
                            implementation: require('sass'),
                            fiber: require('fibers'),
                            // optional
                            indentedSyntax: true
                        }
                    }
                ],
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            }
        ]
    },
    plugins: [
        new VueLoaderPlugin(),
        new VuetifyPlugin({ autoImport: true }),
    ],
    resolve: {
        modules: [
            path.join(__dirname, 'src', 'main', 'resources', 'static', 'js'),
            path.join(__dirname, 'src', 'main', 'resources', 'static', 'TaskBoard', 'js', 'TaskBoard.js'),
            path.join(__dirname, 'src', 'main', 'resources', 'static', 'TaskBoard', 'js', 'Auth.js'),
            path.join(__dirname, 'node_modules'),
        ],
    }
}