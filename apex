var pathParts = $v("P2_PATH") ? $v("P2_PATH").split('|') : [];
$s("P2_PREVIOUS_LEVEL", lev > 0 ? pathParts[lev - 1] : null);
$s("P2_PATH", lev > 0 ? pathParts.slice(0, lev).join('|') : '');
