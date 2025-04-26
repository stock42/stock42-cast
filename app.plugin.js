// stock42-cast/app.plugin.js
const { withGradleProperties } = require("@expo/config-plugins");

module.exports = function withCast(config) {
  return withGradleProperties(config, (conf) => {
    // añade (o actualiza) las flags AndroidX
    conf.modResults = conf.modResults.filter(
      (item) => !["android.useAndroidX", "android.enableJetifier"].includes(item.key),
    );
    conf.modResults.push(
      { type: "property", key: "android.useAndroidX", value: "true" },
      { type: "property", key: "android.enableJetifier", value: "true" },
    );
    return conf;
  });
};
