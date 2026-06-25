config.devServer.proxy = [
    {
        context: ['/files'],
        target: 'https://juliengournay.fr',
        changeOrigin: true,
        secure: true
    }
];
