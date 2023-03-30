const path = require('path');
const {VueLoaderPlugin} = require('vue-loader');

module.exports = {
    mode: 'development',
    devtool: 'source-map',
    entry: {
        taskBoard:path.join(__dirname, 'src', 'main', 'resources', 'static', 'TaskBoard', 'js', 'TaskBoard.js'),
        main:path.join(__dirname, 'src', 'main', 'resources', 'static', 'css', 'main.css'),
        // auth:path.join(__dirname, 'src', 'main', 'resources', 'static', 'Auth', 'js', 'Auth.js'),
    },
    devServer: {
        static: './dist',
        compress: true,
        port: 8001,
        allowedHosts: [
            'localhost:9999'
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
                test: /\.css$/i,
                use: ['style-loader', 'css-loader'],
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            }
        ]
    },
    plugins: [
        new VueLoaderPlugin(),
    ],
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.esm.js'
        },
        modules: [
            path.join(__dirname, 'src', 'main', 'resources', 'static', 'js'),
            path.join(__dirname, 'src', 'main', 'resources', 'static', 'TaskBoard', 'js', 'TaskBoard.js'),
            path.join(__dirname, 'src', 'main', 'resources', 'static', 'TaskBoard', 'js', 'Auth.js'),
            path.join(__dirname, 'node_modules'),
        ],
    }
}